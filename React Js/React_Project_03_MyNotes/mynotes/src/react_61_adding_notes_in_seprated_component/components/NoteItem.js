import React from 'react'

function NoteItem(props) {
    const { note } = props;
    return (
        <div className='col-md-3 p-0 px-2'>
            <div className='card my-2'>
                <div className='card-body'>
                    <h5 className='card-title'>{note.title}</h5>
                    <p className='card-text'>{note.description}</p>
                    <p className='card-text'>{note.date}</p>
                </div>
            </div>
        </div>
    )
}

export default NoteItem