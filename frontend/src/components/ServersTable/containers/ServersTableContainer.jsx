import ServersTable from '../components/ServersTable';
import {connect} from 'react-redux';
import {requestGetServers} from '../../../store/servers'

const mapStateToProps = (state) => {
  return {
    servers: state.servers.servers,
    loading: state.servers.loading,
    errors: state.servers.errors
  };
};

const mapDispatchToProps = (dispatch) => {
  return {
    getServers: () => dispatch(requestGetServers())
  }
};

export default connect(mapStateToProps, mapDispatchToProps)(ServersTable);
