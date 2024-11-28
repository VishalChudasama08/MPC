import React from 'react';
import { useSelector } from 'react-redux';

const ObjectList = () => {
    const objects = useSelector((state) => state.objects.items);

    return (
        <div className="row">
            {objects.map((obj, index) => (
                <div key={index} className="col-md-4 mb-3">
                    <div className="card">
                        <div className="card-body">
                            <h5>{obj.name}</h5>
                            <p>{obj.description}</p>
                        </div>
                    </div>
                </div>
            ))}
        </div>
    );
};

export default ObjectList;
