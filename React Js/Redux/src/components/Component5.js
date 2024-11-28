import React from 'react';

function Component5() {
    // Create an array to represent the number of cards
    const cards = [
        {
            'title': 'Apple iPhone 16 Pro Max',
            'description': 'With its titanium design, A17 Pro chip, and advanced camera system, the iPhone 15 Pro Max sets a new standard for smartphones. Enjoy unmatched performance, stunning photography, and all-day battery life in a sleek package.',
            'color': 'primary'
        },
        {
            'title': 'Dell XPS 13 Plus Laptop',
            'description': "The Dell XPS 13 Plus combines premium craftsmanship with top-tier performance. Its edge-to-edge display and ultra-slim body make it a standout, while the 13th Gen Intel Core processors and long-lasting battery, from heavy multitasking to creative design.",
            'color': 'success'
        },
        {
            'title': 'Kawasaki Ninja H2R',
            'description': 'The Kawasaki Ninja H2R is a track-focused hyperbike boasting a supercharged 998cc engine, producing over 300 horsepower. With its aerodynamic design, advanced technology, and blistering speed, the H2R is built for those seeking the thrill of the track.',
            'color': 'info'
        }
    ]

    return (
        <div className='border border-warning rounded p-3'>
            This is Component 5
            <div className='row'>
                {cards.map((card, index) => (
                    <div key={index} className={`card border-${card.color} m-2 p-0 col`} style={{ width: '18rem' }}>
                        <div className={`card-body text-${card.color}`}>
                            <h5 className="card-title">{card.title}</h5>
                            <p className="card-text" style={{ textAlign: "justify" }}>{card.description}</p>
                            <div className="p-0 m-0 d-flex justify-content-between">
                                <button className={`btn btn-outline-${card.color} me-3`}>Add to Card</button>
                                <button className={`btn btn-outline-${card.color}`}>Buy Now</button>
                            </div>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    );
}

export default Component5;
