import icone from "../../assets/img/notification.svg"

import './styles.css'

function NotificationButton() {
    return (
        <>
            <div className="dsmeta-red-btn">
                <img src={icone} alt="Notificar" />
            </div>
        </>
    )
}

export default NotificationButton
