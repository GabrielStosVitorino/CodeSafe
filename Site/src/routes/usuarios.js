var express = require("express");
var router = express.Router();

var usuarioController = require("../controllers/usuarioController");

router.get("/", function(req, res) {
    usuarioController.testar(req, res);
});

router.get("/listar", function(req, res) {
    usuarioController.listar(req, res);
});

router.post("/cadastrarSimples", function(req, res) {
    usuarioController.cadastrarSimples(req, res);
});

router.post("/cadastrarEmpresa", function(req, res) {
    usuarioController.cadastrarEmpresa(req, res);
});

router.post("/entrar", function(req, res) {
    usuarioController.entrar(req, res);
});

router.post("/cadastrarUsuario", function(req, res) {
    usuarioController.cadastrarUsuario(req, res);
});

router.post("/cadastrarChave", function(req, res) {
    usuarioController.cadastrarChave(req, res);
});

router.post("/autenticar", function(req, res) {
    usuarioController.entrar(req, res);
});
  
module.exports = router;