function handleMenu() {	
	document.querySelector('.button__menu-mobile').classList.toggle('active')
	document.querySelector('.main-menu').classList.toggle('active')
}

function closeInscripcionModal() {
	let modal = document.querySelector(".inscripcion-modal__container")
	if(!modal) return
	modal.parentElement.removeChild(modal)
}