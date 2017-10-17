import React from 'react'
import PropTypes from 'prop-types'
import './PageLayout.scss'
import '../../styles/main.scss'
import Navbar from '../../components/Navbar'

export const PageLayout = ({children}) => (
  <div>
    <Navbar/>
    <div className="container-fluid">
      {children}
    </div>
  </div>
)
PageLayout.propTypes = {
  children: PropTypes.node,
}

export default PageLayout
