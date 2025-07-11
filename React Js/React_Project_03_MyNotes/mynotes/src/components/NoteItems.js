import React, { useContext } from 'react'
import noteContext from '../context/notes/NoteContext'

function NoteItems(props) {
   const { note, updateNote } = props;
   const { deleteNote } = useContext(noteContext);
   return (
      <div className='col p-0 px-2'> {/*col-lg-3 col-md-4 col-sm-5*/}
         <div className='card my-2'>
            <span className="position-absolute rounded-start text-dark my-2 px-3" style={{ top: '-1px', right: '-1px', zIndex: '1' }}>
               <i className='far fa-trash-alt mx-3' onClick={() => { deleteNote(note._id); }}></i>
               <i className='far fa-edit' onClick={() => { updateNote(note) }}></i>
            </span>
            <div className='card-body'>
               <h5 className='card-title '>{note.title}</h5>
               <p className='card-text'>{note.description.split(/\s+/).slice(0, 30).join(' ')}</p>
               <p className='card-text'>{note.date}</p>
            </div>
         </div>
      </div>
   )
}

export default NoteItems