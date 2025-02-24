import React from 'react'

function NoteItem(props) {
    const { note } = props;
    return (
        <div className='col-md-3 p-0 px-2'>
            <div className='card my-2'>
                <span className="position-absolute rounded-start text-dark my-2 px-3" style={{ top: '-1px', right: '-1px', zIndex: '1' }}>
                    <i className='far fa-trash-alt mx-3'></i>
                    <i className='far fa-edit'></i>
                </span>
                <div className='card-body'>
                    <h5 className='card-title '>{note.title}</h5>
                    <p className='card-text'>{note.description}</p>
                    <p className='card-text'>{note.date}</p>
                </div>
            </div>
        </div>
    )
}

export default NoteItem