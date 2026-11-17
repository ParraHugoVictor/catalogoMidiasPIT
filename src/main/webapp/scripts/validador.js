/**
 * Validação de formulário 
 * *@author Victor Parra
 */

function validar() {
    let nome = formMidia.nome.value
    let genero = formMidia.genero.value
    let autor = formMidia.autor.value
    let ano = formMidia.ano.value
    let tipo = formMidia.tipo.value

    if (nome === "") {
        alert("Preencha o campo Nome")
        formMidia.nome.focus()
        return false
    } else if (genero === "") {
        alert("Preencha o campo Gênero")
        formMidia.genero.focus()
        return false
    } else if (autor === "") {
        alert("Preencha o campo Autor")
        formMidia.autor.focus()
        return false
    } else if (ano === "" || !/^\d{4}$/.test(ano)) {
        alert("Preencha o campo Ano com um numero de 4 digitos")
        formMidia.ano.focus()
        return false
    } else if (tipo === "") {
        alert("Preencha o campo Tipo")
        formMidia.tipo.focus()
        return false
    }
	
	return true;
}