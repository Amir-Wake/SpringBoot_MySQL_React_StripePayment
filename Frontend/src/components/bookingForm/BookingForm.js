import {React,useState} from 'react'
import DatePicker from 'react-datepicker';
import setHours from 'date-fns/setHours'
import setMinutes from 'date-fns/setMinutes'
import 'react-datepicker/dist/react-datepicker.css'
import axios from 'axios';
import { useNavigate } from "react-router-dom";
import './BookingForm.css'
function BookingForm() {
    //Form values
    const [nameValue, setNameValue] = useState("");
    const nameInput = (e) => setNameValue(e.target.value);

    const [emailValue, setEmailValue] = useState("");
    const emailInput = (e) => setEmailValue(e.target.value);

    const [phoneValue, setPhoneValue] = useState("");
    const phoneInput = (e) => setPhoneValue(e.target.value);

    const [peopleValue, setPeopleValue] = useState("");
    const peopleInput = (e) => setPeopleValue(e.target.value);

    //Date and time picker
    const [startDate, setStartDate] = useState(
    setHours(setMinutes(new Date(), 30), 12));  
    const date = startDate.toISOString().slice(0, 10);
    const time = startDate.toTimeString().slice(0, 5); 
    const [formSubmitted, setFormSubmitted] = useState(false);

    // Response data
    const [responseData,setResponseData]=useState("");
    const navigate = useNavigate();

    //Handle post form
    const handleForm = (e) => {
        const booking = { 
          "name": nameValue,
          "email": emailValue,
          "phone_num": phoneValue,
          "people_num": parseInt(peopleValue),
          "date": `${date} ${time}`
        };
      
        navigate('/payment', { state: booking });}

    //     e.preventDefault();
    //     setFormSubmitted(true);
    //     axios.post('http://localhost:8080/api/booking', booking, {
    //       headers: {
    //         'Content-Type': 'application/json',
    //         'Access-Control-Allow-Origin': '*'
    //       }
    //     })
    //     .then(response => {
    //         if(response.status=200){
    //       const data = { bookingReference: response.data };
    //       navigate('/payment', { state: data });}
    //     })
    //     .catch(error => {
    //       console.error(error);
    //     });

   

    //   };

    return (
    <div className='container'>
        <div className='booking-form'>
            <h3>Book a table</h3>
            <form >
            <div className='form'>
                    <div className='name'>
                    <label>Name: </label>
                    <input type="text" value={nameValue} onChange={nameInput} required/>
                    {formSubmitted && !nameValue && <span className='error'>Name is required</span>}
                    </div>
                    <div className='email'>
                    <label>Email: </label>
                    <input type="text" value={emailValue} onChange={emailInput} required/>
                    {formSubmitted && !emailValue && <span className='error'>Email is required</span>}
                    </div>
                    <div className='phone-num'>
                    <label>Phone: </label>
                    <input type="text" value={phoneValue} onChange={phoneInput} required/>
                    {formSubmitted && !phoneValue && <span className='error'>Phone is required</span>}
                    </div>
                    <div className='date'>
                        <label>Select a date: </label>
                    <DatePicker
                    selected={startDate}
                    onChange={(date) => setStartDate(date)}
                    showTimeSelect
                    minTime={setHours(setMinutes(new Date(), 30), 12)}
                    maxTime={setHours(setMinutes(new Date(), 30), 20)}
                    dateFormat="d/MM/yyyy h:mm aa"
                     />
                    </div>
                    <div className='people'>
                    <label>Number of people: </label>
                    <input type="text" value={peopleValue} onChange={peopleInput} required/>
                    {formSubmitted && !peopleValue && <span className='error'>Number of people is required</span>}
                    </div>
                    <div className='submit'>
                        <button onClick={handleForm} >
                        Book</button>
                    </div>
                </div>
            </form>

        </div>

    </div>
  )
}

export default BookingForm