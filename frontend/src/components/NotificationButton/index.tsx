import axios from "axios";
import { toast } from "react-toastify";
import icone from "../../assets/img/notification.svg"
import { BASE_URL } from "../../utils/request";

import './styles.css'

type Props ={
    saleId: number;

}

function handleClick(id: number){
    axios(`${BASE_URL}/sales/${id}/notification`).then(Response => {
        toast.info('SMS Enviado com Sucesso!')
    })
}

function NotificationButton({saleId} : Props) {
    return (
        <>
            <div className="dsmeta-red-btn" onClick={() => handleClick(saleId)}>
                <img src={icone} alt="Notificar" />
            </div>
        </>
    )
}

export default NotificationButton
