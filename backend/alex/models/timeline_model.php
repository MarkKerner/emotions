<?php
class Timeline_model extends CI_Model {

    public function __construct()
    {
        $this->load->database();
    }

    public function get_timeline($slug = FALSE) {
        if($slug === FALSE){
            $query = $this->db->get('timeline');
            return $query->result_array();
        }

        $query = $this->db->get_where('timeline', array('slug' => $slug));
        return $query->row_array();


    }
}