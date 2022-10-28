const Toast = Swal.mixin({
    toast: true,
    position: 'bottom-right',
    iconColor: 'white',
    customClass: {
      popup: 'colored-toast'
    },
    showConfirmButton: false,
    timer: 1500,
    timerProgressBar: true
  })
  await Toast.fire({
    icon: 'success',
    title: 'Successo'
  })
  await Toast.fire({
    icon: 'error',
    title: 'Erro'
  })
  await Toast.fire({
    icon: 'warning',
    title: 'Perigo!'
  })
  await Toast.fire({
    icon: 'info',
    title: 'Info'
  })

  