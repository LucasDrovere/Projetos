$(function() {

	$('#link-cadastrar').click(function() {
		$('#conteudo').load('/CadastroDeEndereco.html', cadastrarPessoas);
	});

	$('#link-listar').click(function() {
		$('#conteudo').load('/listar.html', listarPessoas);
	});

});

var BuscarEnderecoCep = function() {
	$("#container").on(
			'blur',
			'#cepParam',
			function(event) {
				var cep = $('#cepParam').val();

				$.get('https://viacep.com.br/ws/' + cep + '/json/', {}).done(
						function(jsonEndereco) {
							$('#logradouroParam').val(jsonEndereco.logradouro);
							$('#bairroParam').val(jsonEndereco.bairro);
							$('#cidadeParam').val(jsonEndereco.localidade);
							$('#ufParam').val(jsonEndereco.uf);
						});

			});
};

var cadastrarPessoas = function() {

	$("#container").on('click', '#btnsalvar', function(event) {
		var params = {
			nome : $('#nomeParam').val(),
			cpf : $('#cpfParam').val(),
			email : $('#emailParam').val(),
			endereco : {
				cep : $('#cepParam').val(),
				logradouro : $('#logradouroParam').val(),
				numero : $('#numeroParam').val(),
				complemento : $('#numeroParam').val(),
				bairro : $('#bairroParam').val(),
				cidade : $('#cidadeParam').val(),
				uf : $('#ufParam').val()
			}
		};

		$.post('/Pessoa', JSON.stringify(params)).done(function(retorno) {
			console.log(retorno);
			alert('Salvou');
		});
		event.preventDefault();
	});

	BuscarEnderecoCep();

};

var excluirPessoa = function() {
	$("#container").on('click', '#btnExcluir', function(event) {
		var params = {
			cpf : $('#cpfParam').val()
		};

		$.doDelete('/Pessoa', JSON.stringify(params)).done(function(retorno) {
			console.log(retorno);
			alert('Salvou');
		});
		event.preventDefault();
	});
};

var listarPessoas = function() {

	carregarTabela();

	$('#tabela-pessoa').on('click', '.editar', function() {
		var cpf = $(this).attr('cpf');

		$('#conteudo').load('/cadastrar.html', function() {
			funcoesAlterar(cpf);
		});
	});

	$('#tabela-pessoa').on('click', '.excluir', function() {
		var cpf = $(this).attr('cpf');

		$.ajax({
			url : 'http://localhost:8080/Pessoa/' + cpf,
			method : 'DELETE',
			success : function(resposta) {
				if (resposta.sucesso) {
					carregarTabela();
				}
			}
		});

	});

};

var carregarTabela = function() {
	$.ajax({
		url : 'http://localhost:8080/Pessoa',
		method : 'GET',
		success : function(registros) {
			var $tbody = $('#tabela-pessoa >tbody');
			$tbody.html('');

			registros.forEach(function(pessoa) {

				var $tr = $('<tr>');

				var $tdNome = $('<td>').text(pessoa.nome);

				var $tdCep = $('<td>').text(pessoa.endereco.cep);

				var $tdAcoes = $('<td>');
				var $btnEditar = $('<button>').text('Editar')
						.addClass('editar').attr('cpf', pessoa.cpf);
				var $btnExcluir = $('<button>').text('Excluir').addClass(
						'excluir').attr('cpf', pessoa.cpf);

				$tdAcoes.append($btnEditar);
				$tdAcoes.append($btnExcluir);

				$tr.append($tdNome);
				$tr.append($tdCep);
				$tr.append($tdAcoes);
				$tbody.append($tr);

			});

		}
	});
};
