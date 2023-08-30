import React from 'react'
import { BiMailSend, BiPhoneCall, BiSupport } from 'react-icons/bi'

const ContactScreen = () => {
  return (
    <div className="row contactus ">
      <hr></hr>
      <div className="col-md-6 my-6">
        <img
          src="https://media.istockphoto.com/id/1271752802/photo/phone-and-e-mail-icons-on-wooden-cubes-with-contact-us-text-on-blue-background-web-page.jpg?s=612x612&w=0&k=20&c=dk9oPaDy_L9mv_icOMgsFGzEDrX0NUI3I8xBQ-DAxQM="
          alt="contactus"
          style={{ width: '100%' }}
        />
      </div>
      <div className="col-md-4">
        <h1 className="bg-dark p-2 text-white text-center">CONTACT US</h1>
        <p className="text-justify mt-2">
          any query and info about prodduct feel free to call anytime we 24X7
          vaialible
        </p>
        <p className="mt-3">
          <BiMailSend /> : www.help@KrushiMitraapp.com
        </p>
        <p className="mt-3">
          <BiPhoneCall /> : 012-3456789
        </p>
        <p className="mt-3">
          <BiSupport /> : 1800-0000-0000 (toll free)
        </p>
      </div>
    </div>
  )
}

export default ContactScreen
