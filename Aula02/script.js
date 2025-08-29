var Aluno = /** @class */ (function () {
    function Aluno(nome, nusp) {
        this._nome = nome;
        this._nusp = nusp;
    }
    Object.defineProperty(Aluno.prototype, "nome", {
        get: function () {
            return this._nome;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Aluno.prototype, "nusp", {
        get: function () {
            return this._nusp;
        },
        enumerable: false,
        configurable: true
    });
    Aluno.prototype.print = function () {
        alert(a.nusp + " " + a.nome);
    };
    return Aluno;
}());
var a = new Aluno("Fabio", 1234);
a.print();
