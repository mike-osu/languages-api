    // src/components/languages.js

    import React from 'react'

    const Languages = ({ languages }) => {
      return (
        <div>
          <center><h1>Languages</h1></center>
          {languages.map((language) => (
            <div className="card" key={language.id}>
              <div className="card-body">
                <h5 className="card-title">{language.name}</h5>
                <h6 className="card-subtitle mb-2 text-muted">Number of speakers (millions): {language.speakers}</h6>
                <p className="card-text">{language.name}</p>
              </div>
            </div>
          ))}
        </div>
      )
    };

    export default Languages