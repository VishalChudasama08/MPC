import React, { useState } from 'react'

const CursorMove = () => {
    const [position, setPosition] = useState({ x: 0, y: 0 })

    return (
        <div className='rounded m-1' onMouseMove={e => { setPosition({ x: e.clientX, y: e.clientY }) }} style={{ border: '2px solid greenyellow', position: 'relative', width: '500px', height: '500px' }}>
            <div style={{
                position: 'absolute',
                backgroundColor: 'red',
                borderRadius: '50%',
                transform: `translate(${position.x}px, ${position.y}px)`,
                top: -68,
                left: -5,
                width: 20,
                height: 20
            }} />

        </div>
    )
}

export default CursorMove;