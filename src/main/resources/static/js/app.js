fetch(`/api/states/${window.location.pathname.split('/')[2]}`)
	.then(res => res.json())
	.then(data => {
		const body = document.body
		const pageTitle = `<h1>${data.name}</h1>`
		const stateInfo = `
			<span>${data.abbreviation}</span>
			<span>Motto: ${data.motto}</span>			
		`
		
		body.innerHTML += pageTitle
		body.innerHTML += stateInfo
	})
// fetch(`/api/states/${window.location.pathname.split('/')[2]}/cities`)
// 	.then(res => res.json())
// 	.then(data => {
// 		console.log(data)
// 		const citiesList = `<p>${data}</p>`
// 		const body = document.body
// 		body.innerHTML += citiesList 
// 	})