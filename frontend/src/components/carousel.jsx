import React from 'react'
import { Container, Row, Col } from 'react-bootstrap'
import Carousel from 'react-bootstrap/Carousel'

const carousel = () => {
  return (
    <Container fluid>
      <Row>
        <Col>
          <Carousel>
            <Carousel.Item>
              <img
                src="/images farming/HAhw.gif"
                className="d-block w-100" 
                
              />
            </Carousel.Item>
            <Carousel.Item>
              <img
                   src="/images farming/agriculture-tractor-corn-harvest-r4nojyyo1lp1yl7f.gif"
                className="d-block w-100" 
              />
            </Carousel.Item>
            <Carousel.Item>
              <img
                src="/images farming/26uUsAjKTsXCDw7zixZR182JbFKvgzJ9YwsFpTVcRaGCmsqhA1unTgpqNKZiCXxYxzzMw37p5SWs7qj5RGznfefW5bbjBjYzwrRFM1GDghJ35XEybztzpt2qsejewgA6bZ1fF2UJZ8eBpiXa2yWxGku8EJk5Ha31ouBJww.gif"
                className="d-block w-100" 
              />
            </Carousel.Item>
          </Carousel>
        </Col>
      </Row>
    </Container>
  )
}

export default carousel
