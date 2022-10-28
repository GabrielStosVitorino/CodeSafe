const singin = document.querySelector("#logue")
const singup = document.querySelector("#cadastre")
const container = document.querySelector(".container2")

singup.addEventListener('click', () =>{
    container.classList.add("sing-up-mode")
})

singin.addEventListener('click', () =>{
    container.classList.remove("sing-up-mode")
})