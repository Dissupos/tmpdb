import React from 'react'
import ServersTable from '../../../components/ServersTable'
import './HomeView.scss'

export const HomeView = () => (
  <div className="row justify-content-center">
    <main className="col-10" role="main">
      <h1>Dashboard</h1>
      <ServersTable />
    </main>
  </div>
)

export default HomeView
