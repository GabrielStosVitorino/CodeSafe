var medidaModel = require("../models/medidaModel");

/*function buscarUltimasMedidas(req, res) {

    const limite_linhas = 7;

    var idServidor = req.params.idServidor;

    console.log(`Recuperando as ultimas ${limite_linhas} medidas`);

    medidaModel.buscarUltimasMedidas(idServidor, limite_linhas).then(function (resultado) {
        if (resultado.length > 0) {
            res.status(200).json(resultado);
        } else {
            res.status(204).send("Nenhum resultado encontrado!")
        }
    }).catch(function (erro) {
        console.log(erro);
        console.log("Houve um erro ao buscar as ultimas medidas.", erro.sqlMessage);
        res.status(500).json(erro.sqlMessage);
    });
}
*/

function buscarServidoresEmRisco(req, res) {

    var idServidor = req.params.idServidor;

    console.log(`Recuperando medidas em tempo real`);

    medidaModel.buscarMedidasRAMKPI(idServidor).then(function (resultado) {
        if (resultado.length > 0) {
            var percentualRAM = resultado[0].percentualConsumo ?? 0;
        }
        medidaModel.buscarMedidasCPUKPI(idServidor).then(function (resultadoCPU) {
            if (resultadoCPU.length > 0) {
                var percentualCPU = resultadoCPU[0].percentualConsumo ?? 0;
                var novoResultado = { percentualRAM: percentualRAM, percentualCPU: percentualCPU };
                if (resultado.length > 0) {
                    res.status(200).json(novoResultado);
                } else {
                    res.status(204).send("Nenhum resultado encontrado!")
                }
            } else {
                res.status(204).send("Nenhum resultado encontrado!")
            }
        }).catch(function (erro) {
            console.log(erro);
            console.log("Houve um erro ao buscar as ultimas medidas.", erro.sqlMessage);
            res.status(500).json(erro.sqlMessage);
        });
    }).catch(function (erro) {
        console.log(erro);
        console.log("Houve um erro ao buscar as ultimas medidas.", erro.sqlMessage);
        res.status(500).json(erro.sqlMessage);
    });
}

function buscarUltimaData(req, res) {
    var idServidor = req.params.idServidor;

    console.log(`Buscando última data`);

    medidaModel.buscarUltimaData(idServidor).then(function (resultado) {
        if (resultado.length > 0) {
            res.status(200).json(resultado);
        } else {
            res.status(204).send("Nenhum resultado encontrado!")
        }
    }).catch(function (erro) {
        console.log(erro);
        console.log("Houve um erro ao buscar a ultima data.", erro.sqlMessage);
        res.status(500).json(erro.sqlMessage);
    });
}

function buscarMedidasCPUKPI(req, res) {

    var idServidor = req.params.idServidor;

    console.log(`Recuperando medidas em tempo real`);

    medidaModel.buscarMedidasCPUKPI(idServidor).then(function (resultado) {
        if (resultado.length > 0) {
            res.status(200).json(resultado);
        } else {
            res.status(204).send("Nenhum resultado encontrado!")
        }
    }).catch(function (erro) {
        console.log(erro);
        console.log("Houve um erro ao buscar as ultimas medidas.", erro.sqlMessage);
        res.status(500).json(erro.sqlMessage);
    });
}

function buscarMedidasRAMKPI(req, res) {

    var idServidor = req.params.idServidor;

    console.log(`Recuperando medidas em tempo real`);

    medidaModel.buscarMedidasRAMKPI(idServidor).then(function (resultado) {
        if (resultado.length > 0) {
            res.status(200).json(resultado);
        } else {
            res.status(204).send("Nenhum resultado encontrado!")
        }
    }).catch(function (erro) {
        console.log(erro);
        console.log("Houve um erro ao buscar as ultimas medidas.", erro.sqlMessage);
        res.status(500).json(erro.sqlMessage);
    });
}

function buscarMedidasDisco(req, res) {

    var idServidor = req.params.idServidor;

    console.log(`Recuperando medidas em tempo real`);

    medidaModel.buscarMedidasDisco(idServidor).then(function (resultado) {
        if (resultado.length > 0) {
            res.status(200).json(resultado);
        } else {
            res.status(204).send("Nenhum resultado encontrado!")
        }
    }).catch(function (erro) {
        console.log(erro);
        console.log("Houve um erro ao buscar as ultimas medidas.", erro.sqlMessage);
        res.status(500).json(erro.sqlMessage);
    });
}

function buscarMedidasRAM(req, res) {

    var idServidor = req.params.idServidor;

    console.log(`Recuperando medidas em tempo real`);

    medidaModel.buscarMedidasRAM(idServidor).then(function (resultado) {
        if (resultado.length > 0) {
            res.status(200).json(resultado);
        } else {
            res.status(204).send("Nenhum resultado encontrado!")
        }
    }).catch(function (erro) {
        console.log(erro);
        console.log("Houve um erro ao buscar as ultimas medidas.", erro.sqlMessage);
        res.status(500).json(erro.sqlMessage);
    });
}

function buscarMedidasCPU(req, res) {

    var idServidor = req.params.idServidor;

    console.log(`Recuperando medidas em tempo real`);

    medidaModel.buscarMedidasCPU(idServidor).then(function (resultado) {
        if (resultado.length > 0) {
            res.status(200).json(resultado);
        } else {
            res.status(204).send("Nenhum resultado encontrado!")
        }
    }).catch(function (erro) {
        console.log(erro);
        console.log("Houve um erro ao buscar as ultimas medidas.", erro.sqlMessage);
        res.status(500).json(erro.sqlMessage);
    });
}

function listarServidores(req, res) {

    var fkEmpresa = req.params.fkEmpresa;

    medidaModel.listarServidores(fkEmpresa).then(function (resultado) {
        if (resultado.length > 0) {
            res.status(200).json(resultado);
        } else {
            res.status(204).send("Nenhum resultado encontrado!")
        }
    }).catch(function (erro) {
        console.log(erro);
        console.log("Houve um erro ao buscar os avisos: ", erro.sqlMessage);
        res.status(500).json(erro.sqlMessage);
    });
}

module.exports = {
    buscarMedidasCPUKPI,
    buscarMedidasRAMKPI,
    buscarMedidasDisco,
    buscarMedidasRAM,
    buscarMedidasCPU,
    listarServidores,
    buscarUltimaData,
    buscarServidoresEmRisco

}