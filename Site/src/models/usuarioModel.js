var database = require("../database/config")

function listar() {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function listar()");
    var instrucao = `
        SELECT * FROM empresa;
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function entrar(usuario, senha) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function entrar(): ", usuario, senha)
    var instrucao = `
    SELECT usuario,senha,tipoUsuario,fkEmpresaUsuario FROM usuario WHERE usuario = '${usuario}' AND senha = '${senha}';
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function cadastrarSimples(nome_resp, email, telefone, nome_fantasia, servico) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function cadastrarSimples():", nome_resp, email, telefone, nome_fantasia, servico);
    var instrucao = `
        INSERT INTO primeiroCadastro (seu_nome, email, telefone, nome_fantasia, necessidade) VALUES ('${nome_resp}', '${email}','${telefone}', '${nome_fantasia}', '${servico}');
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);

}

function cadastrarEmpresa(razao_social, cnpj, logradouro, numero, bairro, cidade, estado, telefone, email_empresa, site,nome_fantasia, celular, responsavel, telefone_resp, email_resp, celular_resp
    ) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function cadastrarEmpresa():", razao_social, cnpj, logradouro, numero, bairro, cidade, estado, telefone, email_empresa, site,nome_fantasia, celular, responsavel, telefone_resp, email_resp, celular_resp
    );
    var instrucao = `
        INSERT INTO empresa (razao_social, cnpj, logradouro, numero, bairro, cidade, estado, telefone, email_empresa, site, nome_fantasia, celular, responsavel, telefone_resp, email_resp, celular_resp
             ) VALUES ('${razao_social}','${cnpj}','${logradouro}','${numero}','${bairro}','${cidade}','${estado}','${telefone}','${email_empresa}','${site}', '${nome_fantasia}','${celular}','${responsavel}','${telefone_resp}','${email_resp}','${celular_resp}');
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}


function cadastrarUsuario(nome_comp, usuario, senha, email_usu,tipoUsuario) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function cadastrarUsuario():", nome_comp, usuario, senha, email_usu,tipoUsuario);
    var instrucao = `
        INSERT INTO usuario (nome_usuario, usuario, senha, email,tipoUsuario
             ) VALUES ('${nome_comp}','${usuario}', '${senha}', '${email_usu}','${tipoUsuario}');
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function cadastrarChave(num_Chave, FK_EMPRESA) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function cadastrarChave():", num_Chave);
    var instrucao = `
    UPDATE empresa SET chaveSeguranca = '${num_Chave}' WHERE idEmpresa = '${FK_EMPRESA}' `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

module.exports = {
    entrar,
    cadastrarSimples,
    cadastrarEmpresa,
    cadastrarUsuario,
    cadastrarChave,
    listar,
};