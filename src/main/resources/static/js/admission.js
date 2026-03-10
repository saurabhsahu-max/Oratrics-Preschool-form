document.addEventListener("DOMContentLoaded", function(){

const form = document.getElementById("admissionForm");

if(!form) return;

form.addEventListener("submit", function(e){

    e.preventDefault();

    grecaptcha.ready(function(){

        grecaptcha.execute('6LcquIUsAAAAAJdpCAuCa9GCm8H-okRMP1HjSZwQ', {action:'submit'})
        .then(function(token){

            console.log("Generated Token:", token);

            document.getElementById("captchaToken").value = token;

            const formData = new FormData(form);

            fetch("/admission/submit",{
                method:"POST",
                body:formData
            })
            .then(response => {

                if(response.ok){

                    form.style.display = "none";

                    document.getElementById("thankYouCard")
                    .classList.remove("hidden");

                }

            });

        });

    });

});

});