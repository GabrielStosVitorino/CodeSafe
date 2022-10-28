const cadchave = document.querySelector('.cadchave')
const altchave = document.querySelector('.altchave')
const caixa = document.querySelector('.caixa')

altchave.onclick = function(){
    caixa.classList.add('active')
}

cadchave.onclick = function(){
    caixa.classList.remove('active')
}