const sideMenu = document.querySelector("aside")
const menuBtn = document.querySelector(".menu-btn")
const closeBtn = document.querySelector("#close-btn")
const themeToggler = document.querySelector(".theme-toggler")

menuBtn.addEventListener('click', () => {
    sideMenu.style.display = 'block';
})

closeBtn.addEventListener('click', () => {
    sideMenu.style.display = 'none'
})

themeToggler.addEventListener('click', () => {
    document.body.classList.toggle('dark-theme-variables')

    themeToggler.querySelector('span:nth-child(1)').classList.toggle('active')
    themeToggler.querySelector('span:nth-child(2)').classList.toggle('active')
})


Orders.forEach(order => {
    const tr = document.createElement('tr')
    const trContent = `
                        <td><span>${Orders.ID}</span></td>
                        <td><span>${Orders.Nome}</span></td>
                        <td><span>${Orders.CPU}</span></td>
                        <td><span>${Orders.Memória}</span></td>
                        <td class="${Orders.Status === 'Normal' ? 'primary' : Orders.Status ===
                    'Alto Risco' ? 'warning' : Orders.Status === 'Perigoso' ? 'danger' : ''}"><span>${Orders.Status}</span></td>
                        <td class="deta"><a href="#">Detalhes</a></td>
    `

    tr.innerHTML = trContent
    document.querySelector('table tbody').appendChild(tr)
})

