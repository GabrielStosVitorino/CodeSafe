const ctx = document.getElementById('myChart').getContext('2d');
const polar = document.getElementById('polar').getContext('2d');
const pizza = document.getElementById('pizza').getContext('2d');
var myChart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: ['Red', 'Blue', 'Yellow', 'Green'],
        datasets: [{
            label: 'CPU',
            data: [12, 19, 3, 5, 2, 3],
            backgroundColor: [
                'rgb(255, 99, 132)',
                'rgb(54, 162, 235)',
                'rgb(255, 206, 86)',
                'rgb(75, 192, 192)'
            ]
        }]
    },
    options: {
       responsive: true,
    }
});

var myChart = new Chart(polar, {
    type: 'line',
    data: {
        labels: ['Red', 'Blue', 'Yellow', 'Green'],
        datasets: [{
            label: 'Memoria',
            data: [12, 19, 3, 5],
            backgroundColor: [
                'rgb(255, 99, 132)',
                'rgb(54, 162, 235)',
                'rgb(255, 206, 86)',
                'rgb(75, 192, 192)'
            ],
            borderColor: [
                '#fff'
            ],
            borderWidth: 1,
            color: [
                '#fff'
            ]
        }]
    },
    options: {
       responsive: true,
    }
});

var myChart = new Chart(pizza, {
    type: 'pie',
    data: {
        labels: ['Red', 'Blue', 'Yellow', 'Green'],
        datasets: [{
            label: 'Mémoria',
            data: [12, 19, 3, 5],
            backgroundColor: [
                'rgb(255, 99, 132)',
                'rgb(54, 162, 235)',
                'rgb(255, 206, 86)',
                'rgb(75, 192, 192)'
            ]
        }]
    },
    options: {
       responsive: true,
    }
});