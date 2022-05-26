    // src/components/languages.js

    import React from 'react'

    const Languages = ({ languages }) => {
      return (
        <div>
          <div className="go-beavs">Languages</div>
          <br />
          <div className="center">
            {languages.map((language) => (
              <div className="card" key={language.id}>
                <div className="card-body">
                  <h5 className="card-title">{language.name}</h5>
                  <h6 className="card-subtitle mb-2 text-muted">Number of speakers (millions): {language.speakers}</h6>
                  <b>Countries:</b>
                    {
                      language.countries.map((country) => (
                        <div key={country.id}>&nbsp;-&nbsp;{country.name}</div>
                      )
                    )}
                </div>
            </div>
          ))}
        </div>
        </div>
      )
    };

    export default Languages