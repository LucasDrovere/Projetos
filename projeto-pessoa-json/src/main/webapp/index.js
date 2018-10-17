$(document).ready(function () {

    $('#link-cadastrar').click(function () {
        $('#conteudo').load('/cadastrar.html', funcoesCadastrar);
    });

    $('#link-listar').click(function () {
        $('#conteudo').load('/listar.html', funcoesListar);
    });

});

var funcoesCadastrar = function () {

    $('#btn-salvar').click(function () {

        var pessoa = getPessoaJson();

        var opcoes = {
            url: 'http://localhost:8080/pessoa',
            method: 'POST',
            dataType: 'JSON',

            data: JSON.stringify(pessoa),
            success: function (resposta) {
                if (resposta.sucesso) {
                    alert(resposta.mensagem);
                } else {
                    console.log(resposta.mensagem);
                }
            }
        };

        $.ajax(opcoes);
    });

    buscarEnderecoPorCep();

};

var funcoesListar = function () {

    carregarTabela();

    $('#tabela-pessoa').on('click', '.editar', function () {
        var cpf = $(this).attr('cpf');

        $('#conteudo').load('/cadastrar.html', function () {
            funcoesAlterar(cpf);
        });
    });

    $('#tabela-pessoa').on('click', '.excluir', function () {
        var cpf = $(this).attr('cpf');

        $.ajax({
            url: 'http://localhost:8080/pessoa/' + cpf,
            method: 'DELETE',
            success: function (resposta) {
                if (resposta.sucesso) {
                    carregarTabela();
                }
            }
        });

    });

};

var funcoesAlterar = function (cpf) {

    // responsável por carregar os campos na tela
    $.ajax({
        url: 'http://localhost:8080/pessoa/' + cpf,
        method: 'GET',
	
        success: function (pessoa) {
            var endereco = pessoa.endereco;
            $('#cpf').val(pessoa.cpf);
            $('#nome').val(pessoa.nome);
            $('#email').val(pessoa.email);

            $('#endereco-id').val(endereco.id);
            $('#cep').val(endereco.cep);
            $('#logradouro').val(endereco.logradouro);
            $('#numero').val(endereco.numero);
            $('#complemento').val(endereco.complemento);
            $('#bairro').val(endereco.bairro);
            $('#cidade').val(endereco.cidade);
            $('#uf').val(endereco.uf);
        }
    });

    $('#btn-salvar').click(function () {
        var pessoa = getPessoaJson();

        $.ajax({
            url: 'http://localhost:8080/pessoa/' + cpf,
            method: 'PUT',
	    contentType: 'application/json',
            data: JSON.stringify(pessoa),
            success: function (resposta) {
                if (resposta.sucesso) {
                    alert(resposta.mensagem);
                    // voltar pra listagem
                }
            }
        });
    });

    buscarEnderecoPorCep();
};

var carregarTabela = function () {
    $.ajax({
        url: 'http://localhost:8080/pessoa',
        method: 'GET',
        success: function (registros) {
            var $tbody = $('#tabela-pessoa >tbody');
            $tbody.html('');

            registros.forEach(function (pessoa) {

                var $tr = $('<tr>');

                var $tdNome = $('<td>')
                    .text(pessoa.nome);

                var $tdCep = $('<td>')
                    .text(pessoa.endereco.cep);

                var $tdAcoes = $('<td>');
                var $btnEditar = $('<button>')
                    .text('Editar')
                    .addClass('editar')
                    .attr('cpf', pessoa.cpf);
                var $btnExcluir = $('<button>')
                    .text('Excluir')
                    .addClass('excluir')
                    .attr('cpf', pessoa.cpf);

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

var getPessoaJson = function () {
    return {
        "nome": $('#nome').val(),
        "cpf": $('#cpf').val(),
        "email": $('#email').val(),
        "endereco": {
            "id": $('#endereco-id').val(),
            "cep": $('#cep').val(),
            "logradouro": $('#logradouro').val(),
            "numero": $('#numero').val(),
            "complemento": $('#complemento').val(),
            "bairro": $('#bairro').val(),
            "cidade": $('#cidade').val(),
            "uf": $('#uf').val()
        }
    };
};

var buscarEnderecoPorCep = function () {
    $('#cep').blur(function () {
        var cepDigitado = $(this).val();

        if (cepDigitado && cepDigitado.length == 8) {
            $.ajax({
                url: 'http://treinamento023/endereco?cep=' + cepDigitado,
                method: 'GET',
                success: function (endereco) {
                    $('#logradouro').val(endereco.logradouro)
                        .prop('disabled', true);
                    $('#bairro').val(endereco.bairro)
                        .prop('disabled', true);
                    $('#cidade').val(endereco.cidade)
                        .prop('disabled', true);
                    $('#uf').val(endereco.uf)
                        .prop('disabled', true);

                },
                error: function (erro) {
                    alert('CEP não encontrado');
                }
            });
        } else {
            $('#logradouro').val('')
                .prop('disabled', false);
            $('#bairro').val('')
                .prop('disabled', false);
            $('#cidade').val('')
                .prop('disabled', false);
            $('#uf').val('')
                .prop('disabled', false);
        }
    });
};