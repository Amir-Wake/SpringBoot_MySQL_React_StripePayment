import './App.css';
import BookingForm from './components/bookingForm/BookingForm';
import Reference from './components/showReference/Reference';
import Payment from './components/payment/Payment';
import {
  BrowserRouter as Router,
  Routes,
  Route,
  Link
} from "react-router-dom";


function App() {
  return (
    <div className="App">
          <Router>
    <Routes>
          <Route path="/" element= {<BookingForm/>}/>
          <Route path="/booking" element={<Reference/>}/>
          <Route path="/payment" element={<Payment/>}/>
     </Routes>
    </Router>
    </div>
  );
}

export default App;
