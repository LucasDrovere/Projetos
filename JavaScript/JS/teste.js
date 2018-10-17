
console.log('------------- BEGIN VARIAVEIS ------------');

console.log('');

//STRING
var nome = 'Rick';
console.log(typeof nome);

//NUMBER
nome = 2;
console.log(typeof nome);

//NÂO DEFINIDO
var naoDefinido;
console.log(typeof naoDefinido);

//OBJETO
var cores = ['azul', 'preto', 'branco'];
console.log(typeof cores);

console.log('');

console.log('------------- END VARIAVEIS ------------');

console.log('');

console.log('------------- BEGIN ARRAY ------------');

console.log('');

//ACESSO INDICE ARRAY
console.log(cores[2]);

//ADICIONA NO ARRAY
cores[4] = 'verde';
console.log(cores);

//ARRAY COM INSTANCIA
var frutas = new Array();

//INSERE NO ARRAY
frutas.push('banana');
frutas.push('morango');
console.log(frutas);

//REMOVE O ULTIMO INSERIDO NO ARRAY
var removido = frutas.pop();
console.log(frutas, 'removido: ' + removido);



console.log('');

console.log('------------- END ARRAY  ------------');

console.log('');

console.log('------------- BEGIN JSON ------------');

//JSON - JAVASCRIPT OBJECT ANOTATION
var pessoa = {
    nome: 'Lucas',
    sobrenome: 'Rovere',
    idade: 23,
    sexo: 'Masculino',
    carros: ['Gol', 'Uno-Escada', 'BMW', 'Ferrari'],
    getCarro: function(indice){
       return this.carros[indice];
    }
};

//MOSTRA O OBJETO
console.log(pessoa);

console.log('');

//MOSTRA VARIAVEL DO OBJETO COM 
console.log('Nome da pessoa é => ' + pessoa['nome']);

//MOSTRA VARIAVEL DO OBJETO COM PONTO
console.log('Sobrenome da pessoa é => ' + pessoa.sobrenome);

var carro = pessoa.getCarro(1);
console.log('Carro adquirido => ' + carro);


console.log('');

//DEFINIR CLASSES EM JS
function Pessoa(){
    //O QUE ESTIVER NO THIS PODE SER ACESSADO DE FORA
    //PARA PRIVATE UTILIZAR VAR
    this.nome;
    this.sobrenome;
    this.carros = [];

    this.toString = function(){
        return 'Nome: ' + this.nome + ' - Sobrenome: ' 
        + this.sobrenome + ' - Carros: ' 
        + this.getCarro();
    }
    
    this.addCarro = function(carro){
        this.carros.push(carro);
    }

    this.getCarro = function(){
        return this.carros;
    }
};

//INSTANCIAR PESSOA
var p = new Pessoa();
p.nome = 'Rick';
p.sobrenome = 'James';

p.addCarro('Gol Turbao');
p.addCarro('Parati');
p.addCarro('Fusca');

console.log(p.toString());



