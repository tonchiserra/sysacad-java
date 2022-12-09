let selectForm = document.querySelector(".select-abmc-form")
if(selectForm) {
	selectForm.addEventListener("change", e => {
		let allRadios = [...selectForm.querySelectorAll("input")]
		if(!allRadios) return
		
		let radioChecked = allRadios.find(radio => radio.checked)
		if(!radioChecked) return
		
		let allForms = [...document.querySelectorAll(".abmc-form-container")]
		if(!allForms) return
		
		allForms.forEach(form => {
			if(form.id === radioChecked.dataset.form) {
				form.style.display = 'flex'
			}else {
				form.style.display = 'none'
			}
		})
	})	
}