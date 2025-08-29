class Aluno {
    private _nome: string;
    private _nusp: number;
    constructor(nome: string, nusp: number) {
        this._nome = nome;
        this._nusp = nusp;
    }
    get nome() {
        return this._nome;
    }

    get nusp() {
        return this._nusp;
    }
    print() {
        alert(a.nusp + " " + a.nome);
    }
}

let a = new Aluno("Fabio", 1234);
a.print();