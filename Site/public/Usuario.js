function validarSessao() {
    // aguardar();

    var nome = sessionStorage.NOME_USUARIO

    if (email != null && nome != null) {
        nomeUsuario.innerHTML = (` ${nome} `);
        // finalizarAguardar();
    } else {
        alert('Você Não Está Logado!!');
        window.location = "Index.html";
    }
}
validarSessao();

function deslogar() {
    delete sessionStorage.NOME_USUARIO;
}