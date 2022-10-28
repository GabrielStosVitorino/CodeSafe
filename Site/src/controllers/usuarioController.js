var usuarioModel = require("../models/usuarioModel");

var sessoes = [];

function testar(req, res) {
    console.log("ENTRAMOS NA usuarioController");
    res.json("ESTAMOS FUNCIONANDO!");
}

function listar(req, res) {
    usuarioModel.listar()
        .then(function (resultado) {
            if (resultado.length > 0) {
                res.status(200).json(resultado);
            } else {
                res.status(204).send("Nenhum resultado encontrado!")
            }
        }).catch(
            function (erro) {
                console.log(erro);
                console.log("Houve um erro ao realizar a consulta! Erro: ", erro.sqlMessage);
                res.status(500).json(erro.sqlMessage);
            }
        );
}

function entrar(req, res) {
    var usuario = req.body.usuario;
    var senha = req.body.senha;
    var tipoUsuario = req.body.tipoUsuario;

    if (usuario == undefined) {
        res.status(400).send("Seu usuário está undefined!");
    } else if (senha == undefined) {
        res.status(400).send("Sua senha está indefinida!");
    } else {
        usuarioModel.entrar(usuario, senha,tipoUsuario)
            .then(
                function (resultado) {
                    console.log(`\nResultados encontrados: ${resultado.length}`);
                    console.log(`Resultados: ${JSON.stringify(resultado)}`); // transforma JSON em String

                    if (resultado.length == 1) {
                        console.log(resultado);
                        res.json(resultado[0]);
                    } else if (resultado.length == 0) {
                        res.status(403).send("Usuário e/ou senha inválido(s)");
                    } else {
                        res.status(403).send("Mais de um usuário com o mesmo login e senha!");
                    }
                }
            ).catch(
                function (erro) {
                    console.log(erro);
                    console.log("\nHouve um erro ao realizar o login! Erro: ", erro.sqlMessage);
                    res.status(500).json(erro.sqlMessage);
                }
            );
    }

}

function cadastrarSimples(req, res) {
    var nome_resp = req.body.nome_resp;
    var email = req.body.email;
    var telefone = req.body.telefone;
    var nome_fantasia = req.body.nome_fantasia;
    var servico = req.body.servico;

    if (nome_resp == undefined) {
        res.status(400).send("Seu nome está undefined!");
    } else if (email == undefined) {
        res.status(400).send("Seu email está undefined!");
    } else if (telefone == undefined) {
        res.status(400).send("Seu telefone está undefined!");
    } else if (nome_fantasia == undefined) {
        res.status(400).send("Sua empresa está undefined!");
    } else if (servico == undefined) {
        res.status(400).send("Sua necessidade está undefined!");
    } else {
        usuarioModel.cadastrarSimples(nome_resp, email, telefone, nome_fantasia, servico)
            .then(
                function (resultado) {
                    res.json(resultado);
                }
            ).catch(
                function (erro) {
                    console.log(erro);
                    console.log(
                        "\nHouve um erro ao realizar o cadastro! Erro: ",
                        erro.sqlMessage
                    );
                    res.status(500).json(erro.sqlMessage);
                }
            );
    }


}

function cadastrarEmpresa(req, res) {
    var razao_social = req.body.razao_social;
    var cnpj = req.body.cnpj;
    var logradouro = req.body.logradouro;
    var numero = req.body.numero;
    var bairro = req.body.bairro;
    var cidade = req.body.cidade;
    var estado = req.body.estado;
    var telefone = req.body.telefone;
    var email_empresa = req.body.email_empresa;
    var site = req.body.site;
    var nome_fantasia = req.body.nome_fantasia;
    var celular = req.body.celular;
    var responsavel = req.body.responsavel;
    var telefone_resp = req.body.telefone_resp;
    var email_resp = req.body.email_resp;
    var celular_resp = req.body.celular_resp;

    if (nome_fantasia == undefined) {
        res.status(400).send("Seu nome fantasia  está undefined!");
    } else if (razao_social == undefined) {
        res.status(400).send("Seu razao social está undefined!");
    } else if (cnpj == undefined) {
        res.status(400).send("Seu CNPJ está undefined!");
    } else if (site == undefined) {
        res.status(400).send("Seu site está undefined!");
    } else if (logradouro == undefined) {
        res.status(400).send("Seu logradouro está undefined!");
    } else if (numero == undefined) {
        res.status(400).send("Seu numero está undefined!");
    } else if (bairro == undefined) {
        res.status(400).send("Seu bairro está undefined!");
    } else if (cidade == undefined) {
        res.status(400).send("Sua cidade está undefined!");
    } else if (estado == undefined) {
        res.status(400).send("Seu estado está undefined!");
    } else if (telefone == undefined) {
        res.status(400).send("Seu telefone emp está undefined!");
    } else if (celular == undefined) {
        res.status(400).send("Seu celular está undefined!");
    } else if (email_empresa == undefined) {
        res.status(400).send("Seu email emp está undefined!");
    } else if (responsavel == undefined) {
        res.status(400).send("Seu responsavel está undefined!");
    } else if (telefone_resp == undefined) {
        res.status(400).send("Seu telrespon está undefined!");
    } else if (celular_resp == undefined) {
        res.status(400).send("Seu celrespon está undefined!");
    } else if (email_resp == undefined) {
        res.status(400).send("Seu emailrespon está undefined!");
    }
    else {
        usuarioModel.cadastrarEmpresa(razao_social,cnpj,logradouro,numero,bairro,cidade,estado,telefone,email_empresa,site,nome_fantasia,celular,responsavel,telefone_resp,email_resp,celular_resp)

            .then(
                function (resultado) {
                    res.json(resultado);
                }
            ).catch(
                function (erro) {
                    console.log(erro);
                    console.log(
                        "\nHouve um erro ao realizar o cadastro! Erro: ",
                        erro.sqlMessage
                    );
                    res.status(500).json(erro.sqlMessage);
                }
            );
    }
}


function cadastrarUsuario(req, res) {
    var nome_comp = req.body.nome_comp;
    var usuario = req.body.usuario;
    var senha = req.body.senha;
    var email_usu = req.body.email_usu;
    var tipoUsuario = req.body.tipoUsuario;
   

    if (nome_comp == undefined) {
        res.status(400).send("Seu nome está undefined!");
    } else if (usuario == undefined) {
        res.status(400).send("Seu usuario está undefined!");
    } else if (senha == undefined) {
        res.status(400).send("Sua senha está undefined!");
    } else if (email_usu == undefined) {
        res.status(400).send("Seu email está undefined!");
    }
    else {
        usuarioModel.cadastrarUsuario(nome_comp, usuario, senha, email_usu,tipoUsuario)
            .then(
                function (resultado) {
                    res.json(resultado);
                }
            ).catch(
                function (erro) {
                    console.log(erro);
                    console.log(
                        "\nHouve um erro ao realizar o cadastro do usuário! Erro: ",
                        erro.sqlMessage
                    );
                    res.status(500).json(erro.sqlMessage);
                }
            );
    }
}

function cadastrarChave(req, res) {

    console.log(req.body);

    var num_Chave = req.body.num_Chave; 
    var fk = req.body.FK_EMPRESA;

        usuarioModel.cadastrarChave(num_Chave,fk)
            .then(
                function (resultado) {
                    res.json(resultado);
                }
            ).catch(
                function (erro) {
                    console.log(erro);
                    console.log(
                        "\nHouve um erro ao realizar o cadastro do servidor! Erro: ",
                        erro.sqlMessage
                    );
                    res.status(500).json(erro.sqlMessage);
                }
            );
    }

module.exports = {
    entrar,
    cadastrarSimples,
    cadastrarEmpresa,
    cadastrarUsuario,
    cadastrarChave,
    listar,
    testar
}