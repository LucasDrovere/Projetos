$(function(){
	
	$('#btnCadastrar').click(function(){
		
		$("#conteudo").load('cadastrarCRUD.jsp');
		
	});
	

	$('#btnListar').click(function(){
		
		$("#conteudo").load('listarCRUD.jsp');
		
	});
	
	
	$("#conteudo").on('click', '#btn-salvar', function(event){
        var formSerializado = $('#formulario').serialize();
        
        $.post('/Sala/cadastro', formSerializado)
            .done(function(retorno) {
                alert("mensagem servidor" + retorno);
            });
        event.preventDefault();
    })
	
	
	
});