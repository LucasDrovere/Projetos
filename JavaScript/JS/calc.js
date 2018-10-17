function botao( num ){
	var salvo = document.calc.visor.value;
	document.calc.visor.value = salvo + num;
}

function reset(){

}

function calcule(){
	var tela = document.calc.visor.value;
	document.calc.visor.value = eval(tela);
}