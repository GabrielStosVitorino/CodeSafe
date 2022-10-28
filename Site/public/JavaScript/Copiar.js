let copyText = document.querySelector(".vai")
copyText.querySelector(".bt").addEventListener("click", function () {
    let div = copyText.querySelector("textarea")
    div.select()
    document.execCommand("copy")
    copyText.classList.add("active")
    window.getSelection().removeAllRanges()
    setTimeout(function () {
        copyText.classList.remove("active")
    }, 5500)
})


