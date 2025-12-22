/**
 * 
 */

//------------ this is for sliding the images-------------------//

let currentIndex = 0;

function showSlide(index) {
    const slider = document.getElementById('image-slider');
    const slides = document.querySelectorAll('.slide');
    const slideWidth = slides[0].offsetWidth;

    if (index < 0) {
        currentIndex = slides.length - 1;
    } else if (index >= slides.length) {
        currentIndex = 0;
    } else {
        currentIndex = index;
    }

    slider.style.transform = `translateX(${-currentIndex * slideWidth}px)`;
}

function prevSlide() {
    showSlide(currentIndex - 1);
}

function nextSlide() {
    showSlide(currentIndex + 1);
}


//---------------This is for filtering the cars based on seats and segments...

function searchCars() {
       let seats = document.getElementById("seats").value;
       let segment = document.getElementById("segment").value;

       fetch(`http://localhost:8080/cars/filter?seats=${seats}&segment=${segment}`)
           .then(response => response.json())
           .then(data => {
               let carList = document.getElementById("carList");
               carList.innerHTML = "";
               data.forEach(car => {
                   carList.innerHTML += `<p>${car.name} - ${car.segment} - ${car.seats} Seats</p>`;
               });
           });
   }



//------------This function is for the showing the alert box after redirect the page-----------

window.onload = function () {
        // Check if paymentSuccess flag exists in localStorage
        if (localStorage.getItem("paymentSuccess") === "true") {
          // Show success alert
          swal("Good job!", "Car Successfully Booked!", "success");

          // Remove flag to prevent showing the alert again
          localStorage.removeItem("paymentSuccess");
        }
		if(localStorage.getItem("paymentFailed") === "true"){
			// Show alert
		  swal("Something Wrong!", "Car is Not Booked please book again !", "error");
		  
		  // Remove flag to prevent showing the alert again
		  localStorage.removeItem("paymentFailed");
		}
		if(localStorage.getItem("logout")==="true"){
			// Show alert
			swal("Successfully Logout !", "Logout From Admin", "success");
					  
			// Remove flag to prevent showing the alert again
			localStorage.removeItem("logout");
		}
		
	

      };

	  
//----------- This is payment section--------------------------//	  
	  
//first request to server to create order

const paymentStart = () => {
  console.log("payment Started..");
  var amount = $("#payment_field").val();
  console.log(amount);
  if(amount==""||amount==null){
	alert("Amount is Required..");
	return;
  }

$.ajax({
  url:"/user/create_order",
  data: JSON.stringify({ amount: amount, info: "order_request" }),
  contentType: "application/json",
  type: "POST",
  dataType: "json",
  success: function (response) {
    console.log(response);
	if(response.status="created"){
		//open payment form
		let options={
			key:"rzp_test_nfc97ZVxdEK7lD",
			amount:response.amount,
			currency:'INR',
			name:"Apex Automotive",
			description:"Donation",
			image:"",
			order_id:response.id,
			handler:function(response){
				console.log(response.razorpay_payment_id)
				console.log(response.razorpay_order_id);
				console.log(response.razorpay_signature);
				console.log("Payment Successfull");
				
				// Store flag in localStorage
				localStorage.setItem("paymentSuccess", "true");//this is not for the payment integration it explicitly used for the showing the alert box

				// If everything is fine, submit the form
				 document.getElementById("bookingForm").submit();
				
			},
			"prefill": { //We recommend using the prefill parameter to auto-fill customer's contact information, especially their phone number
			        "name": "", //your customer's name
			        "email": "", 
			        "contact": ""  //Provide the customer's phone number for better conversion rates 
			    },
			"notes": {
				       "address": "Tushar033"
				   },
			"theme": {
				       "color": "#3399cc"
					  },
			};
			
			let rzp=new Razorpay(options);
			rzp.on('payment.failed', function (response){
			        console.log(response.error.code);
			        console.log(response.error.description);
			        console.log(response.error.source);
			        console.log(response.error.step);
			        console.log(response.error.reason);
			        console.log(response.error.metadata.order_id);
			        console.log(response.error.metadata.payment_id);
					// Store flag in localStorage
					localStorage.setItem("paymentFailed", "true");//this is not for the payment integration it explicitly used for the showing the alert box
			
					//After payment failed it is Redirect to home page
					window.location.href = "/"; // Change to your actual home URL
				});
			
			rzp.open();
		}
			
	  },
	  error: function (error) {
	    console.log(error);
	    alert("something went wrong !!");
	  },
	});
	};
	
	//This is for log out alert message 
	function logout(){
		localStorage.setItem("logout", "true");
		window.location.href = "/";
	}
	
	 
	