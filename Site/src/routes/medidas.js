var express = require("express");
var router = express.Router();

var medidaController = require("../controllers/medidaController");

router.get("/buscarUltimaData/:idServidor", function(req, res) {
    medidaController.buscarUltimaData(req, res);
});

router.get("/buscarMedidasCPUKPI/:idServidor", function(req, res) {
    medidaController.buscarMedidasCPUKPI(req, res);
});

router.get("/buscarMedidasRAMKPI/:idServidor", function(req, res) {
    medidaController.buscarMedidasRAMKPI(req, res);
});

router.get("/buscarMedidasDisco/:idServidor", function(req, res) {
    medidaController.buscarMedidasDisco(req, res);
});

router.get("/buscarMedidasRAM/:idServidor", function(req, res) {
    medidaController.buscarMedidasRAM(req, res);
});

router.get("/buscarMedidasCPU/:idServidor", function(req, res) {
    medidaController.buscarMedidasCPU(req, res);
});

router.get("/buscarServidoresEmRisco/:idServidor", function(req, res) {
    medidaController.buscarServidoresEmRisco(req, res);
});


router.get("/listarServidores/:fkEmpresa", function (req, res) {
    medidaController.listarServidores(req, res);
});


  
module.exports = router;