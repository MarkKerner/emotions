<?php

class Timeline extends CI_Controller {
    public function __construct()
    {
        parent::__construct();
        $this->load->model('timeline_model');
        $this->load->helper('url_helper');

    }

    public function index(){
        $data['timeline'] = $this->timeline_model->get_timeline();
        $data['title'] = 'Timeline core';

        $this->load->view('templates/header', $data);
        $this->load->view('timeline/index', $data);
        $this->load->view('templates/footer');
    }

    public function view($slug = NULL){
        $data['timeline_item'] = $this->timeline_model->get_model($slug);

        if (empty($data['timeline_item']))
        {
            show_404();
        }

        $data['title'] = $data['timeline_item']['title'];

        $this->load->view('templates/header', $data);
        $this->load->view('timeline/view', $data);
        $this->load->view('templates/footer');
    }
}