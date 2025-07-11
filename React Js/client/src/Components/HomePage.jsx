import React, { useEffect, useState } from 'react'
import { AiOutlineSearch } from 'react-icons/ai'
import { BiCommentDetail } from 'react-icons/bi'
import { BsEmojiSmile, BsFilter, BsMicFill, BsThreeDotsVertical } from 'react-icons/bs'
import { TbCircleDashed } from 'react-icons/tb'
import MessageCard from './MessageCard/MessageCard'
import Profile from './Profile/Profile'
import { ImAttachment } from 'react-icons/im'
import '../css/HomePage.css'
import Chats from './Chat/Chats'
import Status from './Status/Status'
import Menu from '@mui/material/Menu';
import MenuItem from '@mui/material/MenuItem';
import CreateGroup from './Group/CreateGroup';
import useConfirmDialog from '../CustomHooks/useConfirmDialog'; // import 'useConfirmDialog' custom hook
import { useDispatch, useSelector } from 'react-redux'
import { logout } from '../Redux/Auth/Action'
import { useNavigate } from 'react-router-dom'

function HomePage() {
   // const token = localStorage.getItem("token");

   const { auth } = useSelector(store => store);
   console.log("auth from home page: ", auth);


   const dispatch = useDispatch();

   const navigate = useNavigate();

   const { showDialog, ConfirmDialog } = useConfirmDialog();

   const [query, setQuery] = useState();
   const [currantChat, setCurrantChat] = useState(Boolean);
   const [content, setContent] = useState(null);
   const [isProfile, setIsProfile] = useState(false);
   const [createGroup, setCreateGroup] = useState(false);
   const [isChat, setIsChat] = useState(true);

   // useEffect(() => {
   //    dispatch(currentUser(token))
   // }, [token])

   useEffect(() => {
      if (!auth.reqUser) {
         navigate("/signin")
      }
   }, [auth.reqUser])

   const handleLogout = () => {
      dispatch(logout())
   }

   const handleSearch = (value) => {

   }

   const handleClickOnChat = () => {
      if (createGroup) { // click on any chat time if CreateGroup component is running than showing Dialog
         handleCloseCreateGroup();
      }
      setCurrantChat(true);
   }

   const handleClickISChat = (what) => {
      setIsChat(what);
   }

   const handleCreateNewMessage = () => {

   }

   const handleCloseOpenProfile = () => {
      isProfile ? setIsProfile(false) : setIsProfile(true);
   }

   const [anchorEl, setAnchorEl] = React.useState(null);
   const open = Boolean(anchorEl);
   const handleClick = (event) => {
      setAnchorEl(event.currentTarget);
   };
   const handleClose = () => {
      setAnchorEl(null);
   };
   const handleCreateGroup = async () => {
      createGroup ? setCreateGroup(false) : setCreateGroup(true);
      setAnchorEl(null);
   }

   const handleCloseCreateGroup = async () => {
      const userConfirmed = await showDialog("Cancel creating group ?", "Your group members, group name, and icon will not be saved. Are you sure?."); // showDialog function take 2 argument 1st->title, 2nd->content
      if (userConfirmed) {
         createGroup ? setCreateGroup(false) : setCreateGroup(true);
         setAnchorEl(null);
      }
   }

   const chatMessages = [
      { "thisUser": true, "message": "Hey! Long time no see. How have you been? 😊" },
      { "thisUser": false, "message": "I’ve been doing alright! Things have been a bit hectic lately with work and some personal projects, but it’s all good." },
      { "thisUser": false, "message": "What about you? How’s life treating you?" },
      { "thisUser": true, "message": "Oh, I hear you! Life has its way of keeping us on our toes, doesn’t it? I’ve been good, though—busy as well, but in a good way. Started a new fitness routine recently, and it’s been surprisingly refreshing." },
      { "thisUser": true, "message": "Have you been up to anything exciting?" },
      { "thisUser": false, "message": "A new fitness routine? That’s awesome! What kind of workouts are you doing? As for me, I’ve been learning to cook a few new dishes. Let’s just say my kitchen has seen better days, but it’s been fun experimenting." },
      { "thisUser": true, "message": "Haha, cooking adventures sound like fun, even with the occasional disaster! As for the workouts, I’ve been trying a mix of yoga and strength training. It’s a nice balance, and I actually feel more energetic. What dishes have you been experimenting with?" },
      { "thisUser": false, "message": "Yoga and strength training sound like a solid combo! I bet that helps with stress too. As for me, I’ve been diving into making Italian dishes—pastas, risottos, that kind of stuff. I even tried making tiramisu the other day! It was a bit messy, but it turned out pretty good for a first attempt." },
      { "thisUser": true, "message": "Italian cuisine is such a great choice! Tiramisu?" },
      { "thisUser": true, "message": "Wow, that’s ambitious. Did you get the layers right?" },
      { "thisUser": true, "message": "I hear that’s the trickiest part." },
      { "thisUser": false, "message": "Yeah, the layers were definitely a challenge! I think I got the proportions mostly right, but the presentation… let’s just say it wasn’t quite Instagram-worthy." },
      { "thisUser": false, "message": "Still tasted amazing, though, which is what matters, right?" },
      { "thisUser": true, "message": "Absolutely! Taste is the real winner here. Next time you make tiramisu, save me a piece—I’d love to try your creation. Also, let me know if you want to join a yoga session sometime. It might balance out all the tiramisu! 😉" },
      { "thisUser": false, "message": "Deal! I’ll save you a slice next time, and yoga sounds like a great idea. Let’s plan something soon—it’d be nice to catch up properly!" }
   ];

   return (
      <div className='relative'>

         {/* Inject modal component from custom hook */}
         <ConfirmDialog />

         <div className='py-14 bg-[#00a884] w-full'></div>
         <div className='flex bg-[#f0f2f5] h-[95vh] absolute top-5 left-5 right-5'> {/* style={{ "border": "1px solid red" }} */}

            {/* Profile section */}
            {isProfile && <Profile handleCloseOpenProfile={handleCloseOpenProfile} fullName={auth.reqUser.fullName} />}

            {/* left side section */}
            {!isProfile && <div className='leftSide w-[30%] bg-[#e8e9ec] h-full'>
               {/* login user details / currant user details */}
               <div className='flex justify-between items-center p-3'>
                  <div className='flex items-center space-x-3 cursor-pointer' onClick={handleCloseOpenProfile}>
                     <img className='rounded-full w-10 h-10 cursor-pointer' src="IMG_20230327_101111.jpg" alt="" />
                     <p>{auth.reqUser?.fullName}</p>
                  </div>
                  <div className='space-x-3 text-2xl flex'>
                     <TbCircleDashed className='cursor-pointer mr-1' onClick={() => { handleClickISChat(false) }} />
                     <BiCommentDetail className='cursor-pointer' onClick={() => { handleClickISChat(true) }} />
                     <BsThreeDotsVertical
                        className='cursor-pointer'
                        id="basic-button"
                        aria-controls={open ? 'basic-menu' : undefined}
                        aria-haspopup="true"
                        aria-expanded={open ? 'true' : undefined}
                        onClick={handleClick} />
                     <Menu
                        id="basic-menu"
                        anchorEl={anchorEl}
                        open={open}
                        onClose={handleClose}
                        MenuListProps={{
                           'aria-labelledby': 'basic-button',
                        }}
                     >
                        <MenuItem onClick={handleClose}>Profile</MenuItem>
                        <MenuItem onClick={handleCreateGroup}>Create Group</MenuItem>
                        <MenuItem onClick={handleLogout}>Logout</MenuItem>
                     </Menu>
                  </div>
               </div>

               {/* search & find use chat */}
               <div className='relative flex justify-center bg-white py-4 px-3'>
                  <input className='border-none outline-none bg-slate-200 rounded-md w-[90%] pl-9 py-2' type="text"
                     placeholder='Search or start new chat'
                     onChange={(e) => { handleSearch(e.target.value); setQuery(e.target.value); }}
                     value={query} />
                  <AiOutlineSearch className='absolute left-5 top-7' />
                  <div>
                     <BsFilter className='ml-4 text-3xl mt-2' />
                  </div>
               </div>

               {/* All Users chat */}
               {isChat && <Chats query={query} handleClickOnChat={handleClickOnChat} />}

               {/* All Status */}
               {!isChat && <Status />}
            </div>}

            {/* right side section */}
            <div className="rightSide w-[70%] relative flex items-center justify-center">
               {/* Create Group */}
               {createGroup && <CreateGroup handleCloseCreateGroup={handleCloseCreateGroup} handleSearch={handleSearch} />}

               {/* Default page */}
               {/* if click on any chat than hide default page */}
               {!currantChat && !createGroup && <div className="flex flex-col text-center">
                  <img
                     className="max-w-[75%] mx-auto"
                     src="https://res.cloudinary.com/zarmariya/image/upload/v1662264838/whatsapp_multi_device_support_update_image_1636207150180-removebg-preview_jgyy3t.png"
                     alt=""
                  />
                  <p className="text-xl sm:text-2xl md:text-3xl lg:text-4xl text-gray-600">WhatsApp Web</p>
                  <p className="my-5 mx-[15%] text-sm sm:text-base md:text-lg lg:text-xl">Send and receive messages without keeping your phone online. Use WhatsApp on up to 4 linked devices and 1 phone at the same time.</p>
               </div>}

               {/* open chat && Message section */}
               {currantChat && !createGroup && <div className='h-full'>
                  {/* header part */}
                  <div className='w-full'>
                     <div className='flex justify-between items-center p-3'>
                        <div className='flex items-center space-x-3'>
                           <img className='rounded-full w-10 h-10 cursor-pointer' src="krishna.jpg" alt="" />
                           <p>UserName</p>
                        </div>
                        <div className='space-x-3 text-2xl flex'>
                           <AiOutlineSearch className='cursor-pointer' />
                           <BsThreeDotsVertical className='cursor-pointer' />
                        </div>
                     </div>
                  </div>

                  {/* message view section */}
                  <div className='h-[83%] overflow-y-scroll bg-blue-100'>
                     <div className='space-y-1 flex flex-col justify-center border p-2'>
                        {chatMessages.map((item) => (
                           <MessageCard isReqUserMassage={item.thisUser} massageContent={item.message} />
                        ))}
                     </div>
                  </div>

                  {/* write and send message section */}
                  <div className='bg-[#f0f2f5] absolute bottom-0 w-full py-3'>
                     <div className='flex justify-between items-center px-5 relative text-2xl'>
                        <BsEmojiSmile className='cursor-pointer' />
                        <ImAttachment className='cursor-pointer' />
                        <div className='w-[85%]'>
                           <input className='outline-none border-none bg-slate-200 w-full rounded-md pl-8 py-2 text-xl'
                              onChange={(e) => { setContent(e.target.value) }}
                              value={content}
                              onKeyPress={(e) => {
                                 if (e.key === "Enter") {
                                    handleCreateNewMessage();
                                    setContent("");
                                 }
                              }}
                              placeholder='Type message'
                              type="text"
                           />
                        </div>
                        <BsMicFill />
                     </div>
                  </div>
               </div>}
            </div>

         </div>
      </div>
   )
}

export default HomePage