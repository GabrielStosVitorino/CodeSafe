function cadastrarSimples() {

    var formulario = new URLSearchParams(new FormData(document.getElementById("form_cadastroSimples")));

    var nome_resp = formulario.get("nome_resp");
    var email = formulario.get("email");
    var telefone = formulario.get("telefone");
    var nome_fantasia = formulario.get("nome_fantasia");
    var servico = formulario.get("servico");


    if (nome_resp == "" || email == "" || telefone == "" || nome_fantasia == "" || servico == "") {

        window.alert("Preencha todos os campos para prosseguir!");
        if (nome_resp == "") {
            console.log('nome está em branco')
        }
        if (email == "") {
            console.log('email está em branco')
        }
        if (telefone == "") {
            console.log('telefone está em branco')
        }
        if (nome_fantasia == "") {
            console.log('empresa está em branco')
        }
        if (servico == "") {
            console.log('servico está em branco')
        }
        return false;
    }

    if (nome_resp.length < 1) {
        window.alert("Nome inválido!");
        return false;
    }

    if (email.indexOf("@") == -1 || email.indexOf(".com") == -1) {
        window.alert("Seu e-mail está inválido!");
        return false;
    }
    if (telefone.length < 9) {
        window.alert("Telefone inválido!");
        return false;
    }
    if (nome_fantasia.length < 1) {
        window.alert("Empresa inválida!");
        return false;
    }
    if (servico.length < 1) {
        window.alert("Insira um motivo válido!");
        return false;
    }

    fetch("/usuarios/cadastrarSimples", {
        method: "POST",
        body: formulario
    }).then(function (resposta) {

        console.log("resposta: ", resposta);

        if (resposta.ok) {
            window.alert("Cadastro realizado com sucesso! Entraremos em contato");
            window.location = "Index.html";
            limparFormulario();
        } else {
            throw ("Houve um erro ao tentar realizar o cadastro!");
        }
    }).catch(function (resposta) {
        console.log(`#ERRO: ${resposta}`);
    });

    return false;
}



function cadastrarEmpresa() {

    var formulario = new URLSearchParams(new FormData(document.getElementById("form_cadastro")));

    razao_social, cnpj, logradouro, numero, bairro, cidade, estado, telefone, email_empresa, site, nome_fantasia, celular, responsavel, telefone_resp, email_resp, celular_resp

    var razao_social = formulario.get("razao_social");
    var cnpj = formulario.get("cnpj");
    var logradouro = formulario.get("logradouro");
    var numero = formulario.get("numero");
    var bairro = formulario.get("bairro");
    var cidade = formulario.get("cidade");
    var estado = formulario.get("estado");
    var telefone = formulario.get("telefone");
    var email_empresa = formulario.get("email_empresa");
    var site = formulario.get("site");
    var nome_fantasia = formulario.get("nome_fantasia");
    var celular = formulario.get("celular");
    var responsavel = formulario.get("responsavel");
    var telefone_resp = formulario.get("telefone_resp");
    var email_resp = formulario.get("email_resp");
    var celular_resp = formulario.get("celular_resp");


    if (razao_social == "" || cnpj == "" || logradouro == "" || numero == "" || bairro == "" || cidade == "" || estado == "" || telefone == "" || email_empresa == "" || site == "" || nome_fantasia == "" || celular == "" || responsavel == "" || telefone_resp == "" || email_resp == "" || celular_resp == "") {

        window.alert("Preencha todos os campos para prosseguir!");
        if (razao_social == "") {
            console.log('nome está em branco')
        }
        if (cnpj == "") {
            console.log('razao social está em branco')
        }
        if (logradouro == "") {
            console.log('cnpj está em branco')
        }
        if (numero == "") {
            console.log('site está em branco')
        }
        if (bairro == "") {
            console.log('logradouro está em branco')
        }
        if (cidade == "") {
            console.log('numero está em branco')
        }
        if (estado == "") {
            console.log('numero está em branco')
        }
        if (telefone == "") {
            console.log('cidade está em branco')
        }
        if (email_empresa == "") {
            console.log('estado está em branco')
        }
        if (site == "") {
            console.log('telefone emp está em branco')
        }
        if (nome_fantasia == "") {
            console.log('celular está em branco')
        }
        if (celular == "") {
            console.log('email emp está em branco')
        }
        if (responsavel == "") {
            console.log('responsavel está em branco')
        }
        if (telefone_resp == "") {
            console.log('telrespon está em branco')
        }
        if (email_resp == "") {
            console.log('celrespon está em branco')
        }
        if (celular_resp == "") {
            console.log('email respon está em branco')
        }

        return false;
    }


    if (cnpj.length < 14) {
        window.alert("Seu CNPJ não é válido");
        return false;
    }

    fetch("/usuarios/cadastrarEmpresa", {
        method: "POST",
        body: formulario
    }).then(function (resposta) {

        console.log("resposta: ", resposta);

        if (resposta.ok) {
            window.alert("Cadastro realizado com sucesso!");
            window.location = "Index.html";
            limparFormulario();

        } else {
            throw ("Houve um erro ao tentar realizar o cadastro!");
        }
    }).catch(function (resposta) {
        console.log(`#ERRO: ${resposta}`);

    });

    return false;
}




function entrar() {

    var formulario = new URLSearchParams(new FormData(document.getElementById("form_login")));

    var usuario = formulario.get("usuario");
    var senha = formulario.get("senha");
    var tipoUsuario = formulario.get("tipoUsuario");

    console.log("FORM LOGIN: ", usuario);
    console.log("FORM SENHA: ", senha);


    if (usuario == "" || senha == "") {
        window.alert("Preencha todos os campos para prosseguir!");
        return false;
    }

    fetch("/usuarios/entrar", {
        method: "POST",
        body: formulario
    }).then(function (resposta) {
        console.log("ESTOU NO THEN DO entrar()!")

        if (resposta.ok) {
            console.log(resposta);

            resposta.json().then(json => {
                console.log(json);
                console.log(JSON.stringify(json));


                sessionStorage.USUARIO = json.usuario;
                sessionStorage.SENHA = json.senha;
                sessionStorage.FK_EMPRESA = json.fkEmpresaUsuario;


                setTimeout(function () {
                    alert(`Olá ${sessionStorage.USUARIO}, seja bem vindo! Você será redirecionado.`);

                    window.location.href = "IndexAdm.html";

                }, 1000); // apenas para exibir o loading

            });

        } else {

            console.log("Houve um erro ao tentar realizar o login!");

            resposta.text().then(texto => {
                console.error(texto);
            });
        }

    }).catch(function (erro) {
        console.log(erro);
    })

    return false;

}

function cadastrarUsuario() {

    var formulario = new URLSearchParams(new FormData(document.getElementById("form_cadusuario")));

    var nome_comp = formulario.get("nome_comp");
    var usuario = formulario.get("usuario");
    var senha = formulario.get("senha");
    var email_usu = formulario.get("email_usu");


    if (nome_comp == "" || usuario == "" || senha == "" || email_usu == "") {

        window.alert("Preencha todos os campos para prosseguir!");
        if (nome_comp == "") {
            console.log('nome está em branco')
        }
        if (usuario == "") {
            console.log('usuario está em branco')
        }
        if (senha == "") {
            console.log('senha está em branco')
        }
        if (email_usu == "") {
            console.log('email está em branco')
        }

        return false;
    }

    if (email_usu.indexOf("@") == -1 || email_usu.indexOf(".com") == -1) {
        window.alert("Ops, e-mail inválido! Verifique e tente novamente.");

        return false;
    }

    fetch("/usuarios/cadastrarUsuario", {
        method: "POST",
        body: formulario
    }).then(function (resposta) {

        console.log("resposta: ", resposta);

        if (resposta.ok) {
            window.alert("Cadastro realizado com sucesso!");
            window.location = "IndexAdm.html";
            limparFormulario();

        } else {
            throw ("Houve um erro ao tentar realizar o cadastro!");
        }
    }).catch(function (resposta) {
        console.log(`#ERRO: ${resposta}`);

    });

    return false;
}


function gerarChave() {


    var m = Math.random() * 19 + 1;

    chave.innerHTML = `${m.toFixed(17)}`;

    var formulario = new URLSearchParams(new FormData(document.getElementById("form_chave")));
    fetch("/usuarios/cadastrarChave", {
        method: "POST",
        body: formulario
    }).then(function (resposta) {

        console.log("resposta: ", resposta);

        if (resposta.ok) {
            window.alert("Chave cadastrada com sucessso!");
            window.location = "Index.html";
            limparFormulario();

        } else {
            throw ("Houve um erro ao tentar realizar o cadastro!");
        }
    }).catch(function (resposta) {
        console.log(`#ERRO: ${resposta}`);

    });

    return false;
}

function cadastrarChave() {

    console.log("ENTREI NA FUNCAO");


    var formulario = new URLSearchParams(new FormData(document.getElementById("form_chave")));
    formulario.append("FK_EMPRESA",sessionStorage.FK_EMPRESA);


    fetch("/usuarios/cadastrarChave", {
        method: "POST",
        body: formulario
    }).then(function (resposta) {


            if (resposta.ok) {
                console.log(resposta);

                resposta.json().then(json => {
                    console.log(json);
                    console.log(JSON.stringify(json));

                    sessionStorage.NOME_USUARIO = json.usuario;
                    sessionStorage.NOME_EMPRESA = json.nome_fantasia;
                    sessionStorage.ID_EMPRESA = json.idEmpresa;
                    sessionStorage.FK_EMPRESA = json.fkEmpresaUsuario;

                    setTimeout(function () {
                        alert(`Chave da empresa ${sessionStorage.NOME_EMPRESA}, cadastrada com sucesso!`);
                        window.location.href = "Index.html";
                    }, 1000); // apenas para exibir o loading

                });

            } else {

                console.log("Houve um erro ao tentar cadastrar a chave!");

                resposta.text().then(texto => {
                    console.error(texto);
                });
            }

        }).catch(function (erro) {
            console.log(erro);
        })

    return false;

}