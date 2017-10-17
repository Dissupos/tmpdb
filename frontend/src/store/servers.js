import axios from 'axios';

// ------------------------------------
// Constants
// ------------------------------------

export const GET_SERVERS = 'GET_SERVERS';
export const GET_SERVERS_SUCCESS = 'GET_SERVERS_SUCCESS';
export const GET_SERVER = 'GET_SERVER';
export const GET_SERVER_SUCCESS = 'GET_SERVER_SUCCESS';
export const ADD_SERVER = 'ADD_SERVER';
export const ADD_SERVER_SUCCESS = 'ADD_SERVER_SUCCESS';
export const UPDATE_SERVER = 'UPDATE_SERVER';
export const UPDATE_SERVER_SUCCESS = 'UPDATE_SERVER_SUCCESS';
export const DELETE_SERVER = 'DELETE_SERVER';
export const DELETE_SERVER_SUCCESS = 'DELETE_SERVER_SUCCESS';
export const REQUEST_ERROR = 'REQUEST_ERROR';

const BASE_URL = 'http://127.0.0.1:8080/api';

// ------------------------------------
// Reducer init state
// ------------------------------------
const initialState = {
  servers: [],
  server: null,
  errors: [],
  loading: false
};

// ------------------------------------
// Actions
// ------------------------------------
export function getServersAction() {
  return {
    type: GET_SERVERS
  }
}

export function getServersSuccessAction(servers) {
  return {
    type: GET_SERVERS_SUCCESS,
    servers: servers
  }
}

export function getServerAction() {
  return {
    type: GET_SERVER
  }
}

export function getServerSuccessAction(server) {
  return {
    type: GET_SERVER_SUCCESS,
    server: server
  }
}

export function addServerAction() {
  return {
    type: ADD_SERVER
  }
}

export function addServerSuccessAction(server) {
  return {
    type: ADD_SERVER_SUCCESS,
    server: server
  }
}

export function updateServerAction() {
  return {
    type: UPDATE_SERVER
  }
}

export function updateServerSuccessAction(server) {
  return {
    type: UPDATE_SERVER_SUCCESS,
    server: server
  }
}

export function deleteServerAction() {
  return {
    type: DELETE_SERVER
  }
}

export function deleteServerSuccessAction(server) {
  return {
    type: DELETE_SERVER_SUCCESS,
    server: server
  }
}

export function requestErrorAction(errors) {
  return {
    type: REQUEST_ERROR,
    errors: errors
  }
}

// ------------------------------------
// Async Actions
// ------------------------------------

export function requestGetServers() {
  return (dispatch) => {
    dispatch(getServersAction());
    axios.get(`${BASE_URL}/servers/`)
      .then((response) => {
        let servers = response.data;
        dispatch(getServersSuccessAction(servers));
      }, (response) => {
        dispatch(requestErrorAction(response.errors));
      });
  };
}

// ------------------------------------
// Specialized Action Creator
// ------------------------------------

export const getServer = ({dispatch}) => {
  return (serverId) => dispatch(getServerAction(serverId))
};

export const addServer = ({dispatch}) => {
  return (server) => dispatch(addServerAction(server))
};

export const updateServer = ({dispatch}) => {
  return (server) => dispatch(updateServerAction(server))
};

export const deleteServer = ({dispatch}) => {
  return (server) => dispatch(deleteServerAction(server))
};


// ------------------------------------
// Reducer
// ------------------------------------
export default function serversReducer(state = initialState, action) {
  switch (action.type) {
    case GET_SERVERS:
      return Object.assign({}, state, {loading: true});
    case GET_SERVERS_SUCCESS:
      return Object.assign({}, state, {loading: false, servers: action.servers});
    case GET_SERVER:
      break;
    case  ADD_SERVER:
      break;
    case UPDATE_SERVER:
      break;
    case DELETE_SERVER:
      break;
    case REQUEST_ERROR:
      return Object.assign({}, state, {loading: false, errors: action.errors});
    default:
      return state
  }

};
