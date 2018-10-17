function Professor() {
    this.nome;
    this.materia;
    this.alunos = [];

    this.toString = function () {
        return 'Nome: ' + this.nome + ' - Materia: '
            + this.materia + ' - Alunos: ' + this.getAlunos();
    }

    this.addAluno = function (aluno) {
        this.alunos.push(aluno);
    }

    this.getAlunos = function () {
        return this.alunos;
    }
}

function Aluno() {
    this.nome;
    this.sobrenome;

}

function salvar() {
    var vnome = document.getElementById("nomeProf").value;
    var vmateria = document.getElementById("cboMateria").value;

    if (vnome != null && vmateria != null) {
        var p = new Professor();
        p.nome = vnome;
        p.materia = vmateria;
        console.log(p);
        inserir(p);

        
    }
}

function inserir(Professor) {
    var vnome = document.getElementById("nomeAluno").value;
    var vsobrenome = document.getElementById("sbrnAluno").value;

    var a = new Aluno();
    a.nome = vnome;
    a.sobrenome = vsobrenome;

    
    Professor.addAluno(a);
    
    console.log(p);
    mostrar();
}


function mostrar() {
    var tabela = document.getElementById("tabela");
    var tbody = document.getElementById("tbody");

    tbody.innerHTML = "";

    for (var i = 0; i < alunos.length; i++) {
        tbody.innerHTML += "<tr><td>" + alunos[i].nome + "</td><td>" + alunos[i].sobrenome + "</td>";
    }
}

function remover() {



}


var combo = document.getElementById("cboMateria");

var materias = ["Portugues", "Historia", "Matematica Computacional", "Fisica", "Arte"];

for (var i = 0; i < materias.length; i++) {
    var option = document.createElement("option");

    option.text = materias[i];

    combo.add(option);
}

