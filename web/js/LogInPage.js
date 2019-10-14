function f(  ) {
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if(this.readyState === 4 && this.status ===200){
            document.getElementById("welcome").innerHTML = this.response;
        }
        if(this.status === 401){
            window.location = "./LogInPage.html"
        }
    }
    xhr.open("POST", "http://localhost:8010/welcome");
    xhr.send()
}