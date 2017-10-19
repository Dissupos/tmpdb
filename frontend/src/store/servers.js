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
  last: false,
  first: false,
  totalPages: 0,
  currentPage: 0,
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

export function getServersSuccessAction(data) {
  return {
    type: GET_SERVERS_SUCCESS,
    data: data
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

export function requestGetServers(page) {
  return (dispatch) => {
    dispatch(getServersAction());
    axios.get(`${BASE_URL}/servers/?page=${page}`)
      .then((response) => {
        let data = response.data;
        dispatch(getServersSuccessAction(data));
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
function handleGetServersSuccess(state, data) {

  return Object.assign({}, state, {
    loading: false,
    servers: data && data.content || initialState.servers,
    totalPages: data && data.totalPages || initialState.totalPages,
    last: data && data.last || initialState.last,
    first: data && data.first || initialState.first,
    currentPage: data && data.number || initialState.currentPage
  });
}

export default function serversReducer(state = initialState, action) {
  switch (action.type) {
    case GET_SERVERS:
      return Object.assign({}, state, {loading: true});
    case GET_SERVERS_SUCCESS:
      return handleGetServersSuccess(state, action.data);
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
