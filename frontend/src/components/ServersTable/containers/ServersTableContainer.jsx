import ServersTable from '../components/ServersTable';
import {connect} from 'react-redux';
import {requestGetServers} from '../../../store/servers'

const mapStateToProps = (state) => {
  return {
    servers: state.servers.servers,
    loading: state.servers.loading,
    errors: state.servers.errors,
    first: state.servers.first,
    last: state.servers.last,
    totalPages: state.servers.totalPages,
    currentPage: state.servers.currentPage
  };
};

const mapDispatchToProps = (dispatch) => {
  return {
    getServers: (page) => dispatch(requestGetServers(page))
  }
};

export default connect(mapStateToProps, mapDispatchToProps)(ServersTable);
