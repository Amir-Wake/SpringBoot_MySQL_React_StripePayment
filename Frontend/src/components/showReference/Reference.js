import { React,useEffect, useState } from "react";
import { useLocation } from "react-router-dom";
import axios from "axios";

function Reference(props) {
    const location = useLocation();
    const [booking, setBooking] = useState(null);
    const [reference,setReference]=useState("");
  
    useEffect(() => {
      const searchParams = new URLSearchParams(location.search);
      const name = searchParams.get("name");
      const email = searchParams.get("email");
      const phone_num = searchParams.get("phone_num");
      const people_num = searchParams.get("people_num");
      const date = searchParams.get("date");
  
      setBooking({
        name,
        email,
        phone_num,
        people_num: parseInt(people_num),
        date,
      });
    }, [location.search]);
  
    useEffect(() => {
      if (booking) {
        axios.post('http://localhost:8080/api/booking', booking, {
          headers: {
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*'
          }
        })
        .then(response => {
          if(response.status=200){
            setReference(response.data.bookingRefrence);
          }
        })
        .catch(error => {
          console.error(error);
        });
      }
    }, [booking]);
  
    if (!booking) {
      return <div>Loading...</div>;
    }
  
    return (
      <div className='reference-container'>
        <div className='referenceContain'>
          <h3>Thanks for booking</h3>
          <h3>Your reference number:</h3>
          <h2>{reference}</h2>
        </div>
      </div>
    );
  }
  
  export default Reference;
  