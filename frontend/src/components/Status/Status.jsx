import React from 'react';
import PropTypes from 'prop-types';

const Status = ({status}) => {
  switch (status) {
    case 'WARNING':
      return <i className="fa fa-exclamation-triangle status warning" aria-hidden="true"/>;
    case 'OK':
      return <i className="fa fa-check-circle status success" aria-hidden="true"/>;
    case 'ERROR':
      return <i className="fa fa-times-circle status error" aria-hidden="true"/>;
    default:
      return <i className="fa fa-question-circle status unknown" aria-hidden="true"/>;
  }
};

Status.propTypes = {
  status: PropTypes.string
};

export default Status;
