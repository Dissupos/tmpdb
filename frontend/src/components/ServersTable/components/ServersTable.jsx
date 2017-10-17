import React from 'react';
import PropTypes from 'prop-types';
import Status from '../../Status';

class ServersTable extends React.Component {

  constructor(props) {
    super(props);

    this.createTableRow = this.createTableRow.bind(this)
  }

  componentDidMount() {
    this.props.getServers()
  }

  createTableRow(item) {
    return (
      <tr key={item.name}>
        <td><Status status={item.status}/></td>
        <td>{item.name}</td>
        <td>{item.lastSuccessfulCheck}</td>
        <td>{item.lastUnsuccessfulCheck}</td>
        <td><i className={`fa fa-power-off status ${item.turnOn ? 'success' : 'error'}`} aria-hidden="true"/></td>
      </tr>
    );
  }

  render() {
    return (
      <div className="table-responsive">
        <table className="table main-dashboard-table">
          <thead>
          <tr>
            <th>Status</th>
            <th>Name</th>
            <th>Last successful check</th>
            <th>Last unsuccessful check</th>
            <th>On/Off</th>
          </tr>
          </thead>
          <tbody>
          {this.props.servers.map(this.createTableRow)}
          </tbody>
        </table>
      </div>
    );
  }
}

ServersTable.propTypes = {
  servers: PropTypes.array,
  errors: PropTypes.array,
  loading: PropTypes.bool,
  getServers: PropTypes.func
};

export default ServersTable;
