import React from 'react';
import PropTypes from 'prop-types';
import Status from '../../Status';

class ServersTable extends React.Component {

  constructor(props) {
    super(props);

    this.createTableRow = this.createTableRow.bind(this)
  }

  componentDidMount() {
    this.props.getServers(0)
  }

  createTableRow(item) {
    return (
      <tr key={item.id}>
        <td><Status status={item.status}/></td>
        <td>{item.name}</td>
        <td>{item.lastSuccessCheck}</td>
        <td>{item.lastUnsuccessCheck}</td>
        <td><i className={`fa fa-power-off status ${item.enabled ? 'success' : 'error'}`} aria-hidden="true"/></td>
      </tr>
    );
  }

  createPagination(first, last, current, total) {
    return (
      <nav aria-label="...">
        <ul className="pagination">
          <li className={`page-item ${first && 'disabled'}`}>
            <a className="page-link" href="#" tabindex="-1">Previous</a>
          </li>
          <li className="page-item active"><a className="page-link" href="#">1</a></li>
          <li onClick={this.props.getServers(1)} className="page-item">
            <a className="page-link" href="#">2 <span className="sr-only">(current)</span></a>
          </li>
          <li className="page-item"><a className="page-link" href="#">3</a></li>
          <li className="page-item">
            <a className="page-link" href="#">Next</a>
          </li>
        </ul>
      </nav>
    )
  }

  render() {
    return (
      <div>
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
          {this.createPagination(this.props.first, this.props.last, this.props.currentPage, this.props.totalPages)}
        </div>

        {[this.props.first, this.props.last, this.props.totalPages, this.props.currentPage].join('/')}
      </div>
    );
  }
}

ServersTable.propTypes = {
  servers: PropTypes.array,
  errors: PropTypes.array,
  loading: PropTypes.bool,
  last: PropTypes.bool,
  first: PropTypes.bool,
  totalPages: PropTypes.number,
  currentPage: PropTypes.number,
  getServers: PropTypes.func
};

export default ServersTable;
